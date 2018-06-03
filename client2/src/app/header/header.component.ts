import {DataStorageService} from '../shared/data-storage.service';
import {Component, OnInit, Output} from '@angular/core';
import { HttpEvent, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private dataStorageService: DataStorageService) {}
  ngOnInit() {
  }

  onSaveData() {
    this.dataStorageService.storeQuestions()
      .subscribe(
        (response)=>{
        console.log(response);
        }
    );
  }
  
  onFetchData() {
  this.dataStorageService.getQuestions();
  }

}