import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewreservationComponent } from './newreservation.component';

describe('NewreservationComponent', () => {
  let component: NewreservationComponent;
  let fixture: ComponentFixture<NewreservationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewreservationComponent]
    });
    fixture = TestBed.createComponent(NewreservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
