import { Component, OnInit } from '@angular/core';
import { ComponentService } from '../../services/component.service';
import { ActivatedRoute } from '@angular/router';
import { ComponentModel } from '../../models/component.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-component-detail',
  templateUrl: './component-detail.component.html',
  styleUrls: ['./component-detail.component.css']
})
export class ComponentDetailComponent implements OnInit {

  component$: Observable<ComponentModel>;
  id: number;

  constructor(private componentService: ComponentService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.component$ = this.componentService.getComponent(this.id);
  }
}
