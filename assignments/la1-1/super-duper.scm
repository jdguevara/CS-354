; Scheme copy program
(define (copy source count)
    (cond ((number? source)
            (make-list 1 source))
          ((null? source)
            (make-list 1 source))
          ((string? source)
            (make-list 1 source))
          ((boolean? source)
            (make-list 1 source))
          ((symbol? source)
            (make-list 1 source))
          ((char? source)
            (make-list 1 source))
          (else (make-list count source))))

(define (super-duper source count)
    (cond ((null? source) 
           source)
          ((number? source) 
           source)
          ((string? source) 
           source)
          ((boolean? source)
           source)
          ((symbol? source)
           source)
          ((char? source)
           source)
          ((pair? (list-ref source 0)) 
           (append (copy (super-duper (list-ref source 0) count) count) (super-duper (cdr source) count)))
          (else (append (copy (car source) count) (super-duper (cdr source) count)))))



; Test cases
;; Numbers
(display (super-duper 123 1))
(display "\n")
(display (super-duper 123 2))
(display "\n")
(display (super-duper '(123 123) 2))
(display "\n")
(display (super-duper '(x 123 y) 2))
(display "\n")
(display (super-duper '(x (123) y) 2))
(display "\n")

;; Booleans
(display (super-duper #t 2))
(newline)
(display (super-duper '(#t) 2))
(newline)
(display (super-duper '(x #t y) 2))
(newline)
(display (super-duper '(x (#t) y) 2))
(newline)

;; Symbols
(display (super-duper 'a 2))
(newline)

;; Characters
(display (super-duper #\A 2 ))
(newline)

;; Empty list
(display (super-duper '() 2))
(display "\n")

;; Normal List
(display (super-duper '(x y) 1))
(display "\n")
(display (super-duper '(x y) 2))
(display "\n")

;; Lists within a list (including empty lists)
(display (super-duper '((a b c) y) 3))
(display "\n")
(display (super-duper '(( ) y) 3))
(display "\n")
(display (super-duper '((a b) (c d) y) 3))
(display "\n")
(display (super-duper '(x (c d) y) 2))
(display "\n")
(display (super-duper '(x ( ) y) 2))
(display "\n")
(display (super-duper '(x y (d e)) 2))
(display "\n")
(display (super-duper '(x y (d (e))) 2))
(display "\n")
(display (super-duper '(x ( )) 3))
(display "\n")

