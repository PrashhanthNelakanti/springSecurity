import {TestBed} from '@angular/core/testing';

import {ReachmeService} from './reachme.service';

describe('ReachmeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReachmeService = TestBed.get(ReachmeService);
    expect(service).toBeTruthy();
  });
});
