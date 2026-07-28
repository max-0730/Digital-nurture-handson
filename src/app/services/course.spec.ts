import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { CourseService } from './course';
import { Course } from '../models/course.model';

describe('CourseService', () => {

  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Java',
      code: 'JAVA101',
      credits: 3,
      gradeStatus: 'pending'
    }
  ];

  beforeEach(() => {

    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);

  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should create', () => {

    expect(service).toBeTruthy();

  });

  it('should return all courses', () => {

    service.getCourses().subscribe(courses => {

      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);

    });

    const req = httpMock.expectOne('http://localhost:3000/courses');

    expect(req.request.method).toBe('GET');

    req.flush(mockCourses);

  });

  it('should handle HTTP error', () => {

    service.getCourses().subscribe({

      next: () => {
        throw new Error('Expected an error');
      },

      error: (error) => {

        expect(error.message)
          .toBe('Failed to load courses. Please try again.');

      }

    });

    httpMock.expectOne('http://localhost:3000/courses')
      .flush('Error', {
        status: 500,
        statusText: 'Server Error'
      });

    httpMock.expectOne('http://localhost:3000/courses')
      .flush('Error', {
        status: 500,
        statusText: 'Server Error'
      });

    httpMock.expectOne('http://localhost:3000/courses')
      .flush('Error', {
        status: 500,
        statusText: 'Server Error'
      });

  });

});