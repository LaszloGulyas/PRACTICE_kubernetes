#!/usr/bin/env sh

# $1 : docker image name
# $2 : multipass vm name

docker save "$1" > "$1".tar
echo "Docker imaged saved to file."

multipass transfer "$1".tar microk8s-vm:/home/ubuntu
echo "Docker image file copied to multipass VM."

multipass exec "$2" -- microk8s ctr image import "$1".tar
echo "Docker image imported to microk8s"

multipass exec "$2" -- rm /home/ubuntu/"$1".tar
multipass exec "$2" -- rm -r /home/ubuntu/snap
rm "$1".tar
echo "Cleanup finished."
