import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ReachmeComponent} from './reachme.component';

describe('ReachmeComponent', () => {
  let component: ReachmeComponent;
  let fixture: ComponentFixture<ReachmeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReachmeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReachmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
