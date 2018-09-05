; Scheme la1-1 program

(define (super-duper seq count)
  (if (null? seq)
      0
      (+ (car seq) (sum (cdr seq)))))

(display (sum '(5 6 1 8 3 7)))
(display "\n")
