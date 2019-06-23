import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmgComponent } from './emg.component';

describe('EmgComponent', () => {
  let component: EmgComponent;
  let fixture: ComponentFixture<EmgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
