package com.example.petjetpackcomposeapp.ipc;


interface IMessageService {
    String processMessage(String input);
    int getProcessedCount();
}