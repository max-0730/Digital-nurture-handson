import { AbstractControl, ValidationErrors } from '@angular/forms';

export function courseIdValidator(control: AbstractControl): ValidationErrors | null {

  const value = control.value;

  if (value === null || value === '') {
    return null;
  }

  return value > 0 ? null : { invalidCourseId: true };
}