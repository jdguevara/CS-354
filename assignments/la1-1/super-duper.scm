; Scheme copy program
(define (copy source count)
    (do ((i 1 (1+ i)))
        ((i > count))
        (display source)))

(define (super-duper source count)
    (if (null? source)
        source
        (if (number? source)
            source
        (copy source count))))
        
; (display (super-duper 123 2))
; (display (super-duper '( ) 2))
(display (super-duper '(x) 2))
(display "\n")
