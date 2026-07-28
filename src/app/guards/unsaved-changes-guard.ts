import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentComponent } from '../features/enrollment/reactive-enrollment/reactive-enrollment';

export const unsavedChangesGuard: CanDeactivateFn<ReactiveEnrollmentComponent> = (
  component
) => {

  if (component.enrollForm.dirty) {

    return window.confirm('You have unsaved changes. Leave?');

  }

  return true;

};