import { Injectable } from '@angular/core';

export class BaseService {

  headers = {
    'Content-Type': 'application/json'
  };

  baseUrl = "http://localhost:8000";

  constructor() { }

}
