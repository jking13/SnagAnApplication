import { Component, OnInit, Input, SimpleChange, EventEmitter } from '@angular/core';

import { Page } from '../../model/page';

@Component({
  selector: 'app-pager',
  templateUrl: './pager.component.html',
  styleUrls: ['./pager.component.css'],
  outputs:['pageNumberChange']
})
export class PagerComponent<T> implements OnInit {

  @Input() page: Page<T>;
  totalPages: number[];

  public pageNumberChange = new EventEmitter();

  constructor() { 
  }

  ngOnInit() {
  }

  refreshPages(){
  	if(this.page){
  	var x=[];
  	var i=1;
  	while(x.push(i++)<this.page.totalPages){};
  	this.totalPages = x;
  }
  }

  setPage(page){
  	if(page < this.page.totalPages && page >= 0 && page !== this.page.number){
  		this.pageNumberChange.emit(page);
  	}
  }

  ngOnChanges(changes: {[propKey: string]: SimpleChange}) {
    for (let propName in changes) {
    	if(propName === "page"){
      	  this.refreshPages()
        }
     }
  }

}
