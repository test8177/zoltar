package com.spotify.modelserving.fs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

final class LocalFileSystem implements FileSystem {

  private static final LocalFileSystem instance = new LocalFileSystem();

  public static LocalFileSystem getInstance() {
    return instance;
  }

  @Override
  public InputStream open(String path) throws IOException {
    return new FileInputStream(new File(path));
  }
}
