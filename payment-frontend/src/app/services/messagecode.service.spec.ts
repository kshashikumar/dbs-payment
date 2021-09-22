import { TestBed } from '@angular/core/testing';

import { MessagecodeService } from './messagecode.service';

describe('MessagecodeService', () => {
  let service: MessagecodeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessagecodeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
