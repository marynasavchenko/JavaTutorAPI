import {DataStorageService} from '../shared/data-storage.service';
import {Component, OnInit, Output} from '@angular/core';
import {Response} from '@angular/http';

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
        (response: Response)=>{
        console.log(response);
        }
    );
  }
  
  onFetchData() {
  this.dataStorageService.getQuestions();
  }

}