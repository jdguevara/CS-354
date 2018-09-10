; Scheme copy program
; (define (copy source)


(define (super-duper source count)
    (if (null? source)
        (number? source)
            source))
        
(display (super-duper 123 2))
; (display (super-duper '( ) 2))
; (display (super-duper '(x) 2))
(display "\n")
