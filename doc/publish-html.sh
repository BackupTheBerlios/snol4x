#!/bin/bash
find html -name '*~' | xargs rm
rsync -arv html/ riffraff@shell.berlios.de:/home/groups/snol4x/htdocs/
