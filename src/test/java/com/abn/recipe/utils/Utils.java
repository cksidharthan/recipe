package com.abn.recipe.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class Utils {
  public static JSONObject readJSONFile(String filePath) throws IOException {
    File file = new File(filePath);
    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
    return new JSONObject(content);
  }
}
