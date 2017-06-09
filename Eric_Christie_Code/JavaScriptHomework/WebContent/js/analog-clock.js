let svgNS = "http://www.w3.org/2000/svg";
window.onload = function() {
  for (let i = 1; i < 13; i++) {
    let angle = Math.PI/2 - (2*Math.PI/12) * i;
    let xpos = 200 + 180 * Math.cos(angle);
    let ypos = 200 + 180 * -Math.sin(angle);
    let num = document.createElementNS(svgNS, 'text');
    num.innerHTML = i;
    num.setAttributeNS(null, 'x', xpos);
    num.setAttributeNS(null, 'y', ypos);
    num.setAttributeNS(null, 'font-size', 20);
    num.setAttributeNS(null, 'text-anchor', 'middle');
    document.getElementById('clock').appendChild(num);
  }
  setInterval(function() {
    let hr = document.getElementById('hours');
    let min = document.getElementById('minutes');
    let sec = document.getElementById('seconds');
    let time = getCurrentCoords(120, 150, 160);
    hr.setAttribute('x1', time.h.x1.toString()); hr.setAttribute('y1', time.h.y1.toString()); hr.setAttribute('x2', time.h.x2.toString()); hr.setAttribute('y2', time.h.y2.toString());
    min.setAttribute('x1', time.m.x1.toString()); min.setAttribute('y1', time.m.y1.toString()); min.setAttribute('x2', time.m.x2.toString()); min.setAttribute('y2', time.m.y2.toString());
    sec.setAttribute('x1', time.s.x1.toString()); sec.setAttribute('y1', time.s.y1.toString()); sec.setAttribute('x2', time.s.x2.toString()); sec.setAttribute('y2', time.s.y2.toString());
  }, 1000);
}

function getCurrentAngles() {
  let now = new Date();
  let secondHandAngle = Math.PI/2 - (2*Math.PI/60) * now.getSeconds();
  let minuteHandAngle =  Math.PI/2 - (2*Math.PI/60) * now.getMinutes();
  let hourHandAngle = Math.PI/2 - ((2*Math.PI/12) * now.getHours() + (2*Math.PI/(12*60)) * now.getMinutes());
  return {
    hour: hourHandAngle,
    minute: minuteHandAngle,
    second: secondHandAngle 
  };
}

function getCurrentCoords(hourLength, minuteLength, secondLength) {
  let angles = getCurrentAngles();
  let hr = {
    x1: 200,
    y1: 200,
    x2: 200 + hourLength * Math.cos(angles.hour),
    y2: 200 + hourLength * -Math.sin(angles.hour)
  };
  let min = {
    x1: 200,
    y1: 200,
    x2: 200 + minuteLength * Math.cos(angles.minute),
    y2: 200 + minuteLength * -Math.sin(angles.minute)
  };
  let sec = {
    x1: 200,
    y1: 200,
    x2: 200 + secondLength * Math.cos(angles.second),
    y2: 200 + secondLength * -Math.sin(angles.second)
  }
  return {
    h: hr,
    m: min,
    s: sec
  };
}
