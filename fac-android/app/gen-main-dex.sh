chmod 711 ./gen-main-dex
chmod 711 ./etc/mainDexClasses
chmod 711 ./etc/proguard_linux/bin/proguard.sh
cd etc
if [ -f ../build/intermediates/multi-dex/debug/allclasses.jar ]
then
./mainDexClasses --output ../maindex.keep ../build/intermediates/multi-dex/debug/allclasses.jar
elif [ -f ../build/intermediates/multi-dex/release/allclasses.jar ]
then
./mainDexClasses --output ../maindex.keep ../build/intermediates/multi-dex/release/allclasses.jar
elif [ -f ../build/intermediates/classes-proguard/release/classes.jar ]
then
./mainDexClasses --output ../maindex.keep ../build/intermediates/classes-proguard/release/classes.jar
elif [ -f ../build/intermediates/classes-proguard/debug/classes.jar ]
then
./mainDexClasses --output ../maindex.keep ../build/intermediates/classes-proguard/debug/classes.jar
fi
