// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game-service.proto

package br.com.til.models;

public final class GameServiceOuterClass {
  private GameServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Die_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Die_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Player_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Player_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GameState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GameState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022game-service.proto\"\024\n\003Die\022\r\n\005value\030\001 \001" +
      "(\005\"(\n\006Player\022\014\n\004name\030\001 \001(\t\022\020\n\010position\030\002" +
      " \001(\005\"$\n\tGameState\022\027\n\006player\030\001 \003(\0132\007.Play" +
      "er2+\n\013GameService\022\034\n\004roll\022\004.Die\032\n.GameSt" +
      "ate(\0010\001B\025\n\021br.com.til.modelsP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Die_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Die_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Die_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_Player_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Player_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Player_descriptor,
        new java.lang.String[] { "Name", "Position", });
    internal_static_GameState_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GameState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GameState_descriptor,
        new java.lang.String[] { "Player", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
