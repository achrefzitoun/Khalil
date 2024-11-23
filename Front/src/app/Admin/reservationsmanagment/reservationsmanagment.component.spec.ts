import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationsmanagmentComponent } from './reservationsmanagment.component';

describe('ReservationsmanagmentComponent', () => {
  let component: ReservationsmanagmentComponent;
  let fixture: ComponentFixture<ReservationsmanagmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReservationsmanagmentComponent]
    });
    fixture = TestBed.createComponent(ReservationsmanagmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
