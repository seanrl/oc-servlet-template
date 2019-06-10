## How To - Guide on Using as Template

1. Clone the repository.
2. Delete the .hg directory, and then create a new hg project for your new project
3. Change the project name, repository name, and remote location; to match your new project.
4. Import the project as a gradle project into the IDE of choice.
5. Execute task "gradle run" and navigate in your browser to localhost:8080/ to see it in action.
6. Refactor HelloServlet to be your new servlet name, and replace its code with your functionality.
7. Feel free to keep RootServlet as it is, to handle resource routing and multi-servlet access, or remove it and go solo.
8. When you add your project back to source control, don't forget to include everything in the gradle folder, including gradle-wrapper.jar, which is normally excluded via .hgignore.