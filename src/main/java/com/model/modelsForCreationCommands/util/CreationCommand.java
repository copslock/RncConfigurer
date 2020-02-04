package com.model.modelsForCreationCommands.util;

import com.utils.Patterns;

import java.util.List;
import java.util.Map;


public interface CreationCommand {
  CreationCommand getCreationCommand(Patterns pattern, String source);

  String getName();

  Map<String, String> getValues();

  Patterns getType();
}
