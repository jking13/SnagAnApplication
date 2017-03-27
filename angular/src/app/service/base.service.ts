import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

export class BaseService {

  headers = {
    'Content-Type': 'application/json'
  };

  baseUrl = environment.apiUrl;

  constructor() { }

}
