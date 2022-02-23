import React from 'react';
import axios from 'axios';

const addUrl = "http://localhost:8080/cred/cards/add";
const getAllUrl = "http://localhost:8080/cred/cards/get/all ";

export function getAllCreditCards(callback:any) {
  axios.get(getAllUrl)
  .then((response)=>{
      callback(response);
  })
  .catch((error)=>{
    callback(error);
  })
}

export function addCreditCard(details:any, callback:any) {
  axios.post(addUrl, JSON.stringify(details),{
    headers:{'Content-Type': 'application/json;charset=UTF-8'}
  })
  .then((response)=>{
      callback(response);
  })
  .catch((error)=>{
    callback(error);
  })
}