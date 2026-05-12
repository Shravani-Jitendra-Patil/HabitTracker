import { Component, Input } from '@angular/core';
import { Dashboard } from '../../models/dashboard.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  @Input() dashboard!: Dashboard;
}
