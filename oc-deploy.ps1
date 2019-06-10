$proj_name = "dev-student2"
$build_name = [System.Text.RegularExpressions.Regex]::Replace($(pwd).Path,".*\\", "").ToLower().Replace(" ", "-")
$app_name = $build_name
./gradlew copyDockerFiles

cat build/docker/Dockerfile | oc new-build -D="-" --name=$build_name --strategy=docker
oc start-build $build_name --from-dir=build/docker --follow --wait
oc new-app -i "$build_name" --name=$app_name
ls .\build\docker\wars\ -Filter *.war | % { $tmp_route = $("/" + $_.Name.Replace(".war", "")); echo "exposing $tmp_route"; oc expose svc/$build_name --path $tmp_route}
