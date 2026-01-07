Node-RED
========

Installation
------------

Node-RED can be installed on the target with ``npm``::

   npm install -g node-red

Usage
-----

To start Node-RED on the target, simply run::

   node-red

The web UI can be accessed from a locally connect host via
http://192.168.3.11:1880.

GPIO
----

To process data via general purpose inputs and outputs, install the
corresponding package for ``libgpiod``::

   npm install -g node-red-contrib-libgpiod

Outputs:

===== ========= ===
Name  Device    Pin
===== ========= ===
DOUT1 gpiochip3 27
DOUT2 gpiochip3 24
DOUT3 gpiochip3 26
DOUT4 gpiochip3 21
===== ========= ===

Fault detection of outputs. Those are inputs and are read-only:

===== ========= ===
Name  Device    Pin
===== ========= ===
nST1  gpiochip4 4
nST2  gpiochip4 3
nST3  gpiochip3 29
nST4  gpiochip3 30
===== ========= ===

Input:

===== ========= ===
Name  Device    Pin
===== ========= ===
DIN1  gpiochip4 26
DIN2  gpiochip4 27
DIN3  gpiochip4 28
DIN4  gpiochip4 29
===== ========= ===

RS232/RS485
-----------

For serial communication install::

   npm install -g node-red-node-serialport

CAN
---

For reading and sending CAN frames via the socketcan subsystem, install::

   npm install -g node-red-contrib-socketcan
