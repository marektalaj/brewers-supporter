import { Component, OnInit } from '@angular/core';
import { Batch } from 'src/app/model/Batch';
import { BatchServiceService } from 'src/app/service/batch-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-batches',
  templateUrl: './batches.component.html',
  styleUrls: ['./batches.component.css']
})
export class BatchesComponent implements OnInit {
  batches: Batch[]

  constructor(private batchService: BatchServiceService,
    private router: Router) { }

  ngOnInit() {
    this.batchService.getRecipesByUsername(sessionStorage.getItem('username')).subscribe(
      data => {
        this.batches = data;
      },
      error => {
        window.alert("nie udało się wczytac" );
      }
    )
  }

  goToDetails(id){
    this.router.navigate(['recipes/details', id]);
  }

  deleteBatch(id){
    this.batchService.deleteBatch(id).subscribe(
      data =>{
        this.ngOnInit();
      }
    );
  }

}
