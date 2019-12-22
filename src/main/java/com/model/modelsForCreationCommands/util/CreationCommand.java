package com.model.modelsForCreationCommands.util;

import com.utils.Patterns;

import java.util.List;


public interface CreationCommand {
  CreationCommand getCreationCommand(Patterns pattern, String source);

  List<?> getValues();

  String getType();
}
