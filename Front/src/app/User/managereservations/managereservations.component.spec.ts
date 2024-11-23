import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagereservationsComponent } from './managereservations.component';

describe('ManagereservationsComponent', () => {
  let component: ManagereservationsComponent;
  let fixture: ComponentFixture<ManagereservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagereservationsComponent]
    });
    fixture = TestBed.createComponent(ManagereservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
