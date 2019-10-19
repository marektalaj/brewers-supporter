package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.dto.BrewingParamsDTO;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.services.BatchService;

@RestController
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @PostMapping(value = "/batch/{recipeId}/{authorId}")
    public Batch saveRecipe(@RequestBody BrewingParamsDTO brewingParamsDTO,
                            @PathVariable Long recipeId,
                            @PathVariable Long authorId){
        System.out.println(recipeId+"   "+ authorId);
        return batchService.transformRecipe(brewingParamsDTO, recipeId, authorId);
    }


}
