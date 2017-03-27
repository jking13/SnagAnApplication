import { Component, OnInit, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css'],
  outputs:['searchChange']
})
export class SearchBarComponent implements OnInit {

  public searchChange = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  search(searchTerm){
  	this.searchChange.emit(searchTerm);
  }

}
