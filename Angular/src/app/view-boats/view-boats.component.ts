import { Component, OnInit } from '@angular/core';
import { Boat, BoatGridColumn, BoatType } from '@app/_models';
import { BoatsService } from '@app/_services/boats.service';

@Component({
  selector: 'boats-view-boats',
  templateUrl: './view-boats.component.html'
})
export class ViewBoatsComponent implements OnInit {

  boats: Boat[] = [];

  BoatType: typeof BoatType = BoatType;

  public columns: BoatGridColumn[] = [
    { field: 'name', title: 'Boat Name' },
    { field: 'size', title: 'Size (ft)' },
    { field: 'type', title: 'Boat Type' },
    { field: 'model.model', title: 'Model' },
  ];

  constructor(private boatsService: BoatsService) { }

  ngOnInit() {
    this.boatsService.getAll().subscribe(
      res => {
        this.boats = [...res];
        console.table(this.boats);
      }
    );
  }

}
