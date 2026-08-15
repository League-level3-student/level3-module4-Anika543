/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

	public static int calculateWaitTime(ArrayDeque<Integer> ticketsQueue, int position) {

		int counter = 0;


		while (true) {
			if(position==0 && ticketsQueue.getFirst()==1) {
				counter++; 
				return counter; 
			}
			
			else if(position==0 && ticketsQueue.getFirst()>1) {
				position = ticketsQueue.size()-1; 
			}
			else {
				position--; 
			}

			if (ticketsQueue.getFirst() == 1) {
				ticketsQueue.remove();
				ticketsQueue.add(0);
				counter++; 
			
			} 
			else if(ticketsQueue.getFirst() == 0) {
				ticketsQueue.remove();
				ticketsQueue.add(0); 
			}
			else {
				ticketsQueue.add(ticketsQueue.remove() - 1);
				counter++;
			}
			
		}

		// have a counter for the time
		// remove 1 from the value of the poeple at the front of the line and move them
		// to the back
		// if someones value gets to 0 they get removed from the queue
		// track my friend and end the counter when they reach 0

		// 0 0 1 0 0

	}
}
