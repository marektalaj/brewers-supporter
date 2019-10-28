import { Component, OnInit } from '@angular/core';
import { Batch } from 'src/app/model/Batch';
import { BatchServiceService } from 'src/app/service/batch-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-batch-details',
  templateUrl: './batch-details.component.html',
  styleUrls: ['./batch-details.component.css']
})
export class BatchDetailsComponent implements OnInit {
  id: string;
  batch: Batch;

  constructor(private activRoute: ActivatedRoute,
    private batchSevice: BatchServiceService) { }

  ngOnInit() {
    this.id = this.activRoute.snapshot.paramMap.get('id');
    this.batchSevice.getBatchById(this.id).subscribe(
      data => {
        console.log(data);
        this.batch=data;
      }
    )
  }

}
