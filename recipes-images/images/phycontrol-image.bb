SUMMARY = "phyCONTROL gateway image"
DESCRIPTION = "A complete image containing commonly-used software for phyCONTROL gateways"

require recipes-images/images/phytec-container-image.bb

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL:append = " \
    cockpit \
    cockpit-systemd \
    cockpit-ws \
    cockpit-networkmanager \
    cockpit-dashboard \
    cockpit-shell \
    cockpit-apps \
    cockpit-users \
    cockpit-kdump \
    cockpit-playground \
    cockpit-podman \
    libgpiod-dev \
    make \
    nodejs \
    nodejs-npm \
    dnf-phytec-config \
    thingsboard-gateway \
"
