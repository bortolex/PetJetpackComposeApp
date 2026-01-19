MVI / MVVM у Compose + State Restoration
Завдання:
Реалізувати екран з такими станами:
Loading
Content
Error (з retry)
Empty

Вимоги:
ViewModel + StateFlow
State має:
переживати rotation
коректно відновлюватися після process death
UI — pure Compose, без логіки

Додатково:
Пояснити різницю:
remember
rememberSaveable
SavedStateHandle

Перевіряється:
Архітектурне мислення
Correct state ownership
Production-ready підхід

MVI / MVVM in Compose + State Restoration
Task

Implement a screen that supports the following states:

Loading

Content

Error (with retry)

Empty

Requirements

Use ViewModel + StateFlow

The UI state must:

survive configuration changes (rotation)

be properly restored after process death

UI should be implemented using pure Jetpack Compose, with no business logic in composables

Additional

Explain the difference between:

remember

rememberSaveable

SavedStateHandle

What is evaluated

Architectural thinking

Correct state ownership

Production-ready approach