package com.petsworld.pets.Repositories;

import com.petsworld.pets.Model.Pet;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;public interface PetsRepository extends MongoRepository<Pet, String> {
  Pet findBy_id(ObjectId _id);

  List<Pet> findBySpecies(String species);
  List<Pet> findBySpeciesAndBreed(String species, String breed);
}
