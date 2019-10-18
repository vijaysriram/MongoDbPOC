package com.petsworld.pets.Service;

import com.petsworld.pets.Model.Pet;
import com.petsworld.pets.Repositories.PetsRepository;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

  @Autowired
  private PetsRepository petsRepository;

  public List<Pet> getAllPets() {
    return petsRepository.findAll();
  }

  public List<Pet> getAllBySpecies(String species) {
    return petsRepository.findBySpecies(species);
  }

  public List<Pet> getAllBySpeciesAndBreed(String species, String breed) {
    return petsRepository.findBySpeciesAndBreed(species, breed);
  }

  public Pet updatePet(Pet pet) {
    return petsRepository.save(pet);
  }

  public Pet createPet(Pet pet) {
    pet.set_id(ObjectId.get());
    return petsRepository.save(pet);
  }

}
