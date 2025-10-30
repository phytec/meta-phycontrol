# Copyright (C) 2025 Leonard Anderweit <l.anderweit@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = ""

require recipes-images/images/phytec-container-image.bb

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
"
