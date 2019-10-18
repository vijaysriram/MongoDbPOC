package com.petsworld.pets.Controller;

import com.petsworld.pets.Model.Pet;
import com.petsworld.pets.Service.PetsService;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetsController {

  @Autowired
  private PetsService petsService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Pet> getAllPets() {
    return petsService.getAllPets();
  }

  @RequestMapping(value = "/{species}", method=RequestMethod.GET)
  public List<Pet> getAllBySpecies(@PathVariable("species") String species) {
    return petsService.getAllBySpecies(species);
  }

  @RequestMapping(value = "/{species}/{breed}", method=RequestMethod.GET)
  public List<Pet> getAllBySpecies(@PathVariable("species") String species, @PathVariable("breed") String breed) {
    return petsService.getAllBySpeciesAndBreed(species, breed);
  }


  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Pet modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pet pet) {
    pet.set_id(id);
    return petsService.updatePet(pet);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Pet createPet(@Valid @RequestBody Pet pet) {
    return petsService.createPet(pet);
  }

}
