import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HabitFormComponent } from './components/habit-form/habit-form.component';
import { HabitListComponent } from './components/habit-list/habit-list.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HabitFormComponent,
    HabitListComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
