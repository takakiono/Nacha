package com.example.nacha.common.constants;

public enum ErrorMessage {
    NachaDeleteError("削除できませんでした。")
    ,NachaNotTargetError("削除・更新対象が存在しません。")
    ,NachaExclusionError("すでに更新・削除されています。");

    private String message;

    private ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
