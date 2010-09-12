#!/bin/bash
find html -name '*~' | xargs rm -f
rsync -arv html/ riffraff@shell.berlios.de:/home/groups/snol4x/htdocs/
