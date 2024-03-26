# Setup

Firefox is installed on ubuntu by default with snap, this causes some issues

#my way
1. sudo snap remove firefox
2. sudo apt update & sudo apt install firefox

# 
1. sudo snap remove firefox
2.  sudo install -d -m 0755 /etc/apt/keyrings
3. wget -e https://packages.mozilla.org/apt/repo-signing-key.gpg -O- | sudo tee /etc/apt/keyrings/packages.mozilla.org.asc > dev/null
4. echo "deb"