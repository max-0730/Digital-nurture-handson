import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';

import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

private apiUrl = 'http://localhost:3000/courses';
  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {

  return this.http.get<Course[]>(this.apiUrl).pipe(

    retry(2),

    tap(courses => {

      console.log('Courses loaded:', courses.length);

    }),

    map(courses => courses.filter(course => course.credits > 0)),

    catchError(err => {

      console.error(err);

      return throwError(() => new Error('Failed to load courses. Please try again.'));

    })

  );

}

  getCourseById(id: number): Observable<Course> {

    return this.http.get<Course>(
      `http://localhost:3000/courses/${id}`
    );

  }

  addCourse(course: Omit<Course, 'id'>): Observable<Course> {

    return this.http.post<Course>(
      'http://localhost:3000/courses',
      course
    );

  }
  updateCourse(course: Course): Observable<Course> {

  return this.http.put<Course>(

    `http://localhost:3000/courses/${course.id}`,

    course

  );

}
deleteCourse(id: number): Observable<void> {

  return this.http.delete<void>(

    `http://localhost:3000/courses/${id}`

  );

}

}