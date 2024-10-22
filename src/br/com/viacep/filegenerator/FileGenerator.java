package br.com.viacep.filegenerator;

import br.com.viacep.models.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void saveInJson(Address address) throws IOException {
        String directoryPath = "src/br/com/viacep/zipcodeinjson";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = directoryPath + "/" + address.cep() + ".json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(gson.toJson(address));
        }
    }
}