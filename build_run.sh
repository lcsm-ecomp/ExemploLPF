sdk install kotlin
#Compila os arquivos os arquivos do front-end
for src in `find frontEnd -name "*.kt"`; do
   dest=${src%%.kt}.js
   if [ $src -nt $dest ]; then
       kotlinc-js $src -output $dest
   fi
done

cp -R frontEnd/* backEnd/src/main/resources/static/

cd backEnd
./gradlew bootRun